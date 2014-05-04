package be.kuleuven.graph.rfsm.wizards;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;

import be.kuleuven.model.rfsm.RfsmFactory;
import be.kuleuven.model.rfsm.RfsmGraph;
//import be.kuleuven.model.rfsm.State;

@SuppressWarnings("restriction")
public class FileService {

		/**
		 * @param rfsmPath 
		 * @param hyperGraphName 
		 * @since 0.9
		 */
		public static void createEmfFileForDiagram(URI diagramResourceUri, final Diagram diagram, String hyperGraphName, String rfsmPath) {

			// Create a resource set and EditingDomain
			final TransactionalEditingDomain editingDomain = GraphitiUiInternal.getEmfService()
					.createResourceSetAndEditingDomain();
			final ResourceSet resourceSet = editingDomain.getResourceSet();
			// Create a resource for this file.
			final Resource resource = resourceSet.createResource(diagramResourceUri);
			
			//Create HyperGraph and add it to the diagram resourceSet
			final RfsmGraph rfsmGraph = RfsmFactory.eINSTANCE.createRfsmGraph();
			rfsmGraph.setName(hyperGraphName);
			URI uri = URI.createPlatformResourceURI(rfsmPath, false);
			final Resource orocosPackageResource = resourceSet.createResource(uri);
			
			//Create a link between the diagram and the graph
			PictogramLink link = PictogramsFactory.eINSTANCE.createPictogramLink();
			link.getBusinessObjects().addAll(Arrays.asList(rfsmGraph));
			diagram.setLink(link);
			
			CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					resource.setTrackingModification(true);
					resource.getContents().add(diagram);
					orocosPackageResource.setTrackingModification(true);
					orocosPackageResource.getContents().add(rfsmGraph);
				}
			});

			save(editingDomain, Collections.<Resource, Map<?, ?>> emptyMap());
			editingDomain.dispose();
		}

		private static void save(TransactionalEditingDomain editingDomain, Map<Resource, Map<?, ?>> options) {
			saveInWorkspaceRunnable(editingDomain, options);
		}

		private static void saveInWorkspaceRunnable(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> options) {

			final Map<URI, Throwable> failedSaves = new HashMap<URI, Throwable>();
			final IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {
				public void run(final IProgressMonitor monitor) throws CoreException {

					final Runnable runnable = new Runnable() {
						public void run() {
							Transaction parentTx;
							if (editingDomain != null
									&& (parentTx = ((TransactionalEditingDomainImpl) editingDomain).getActiveTransaction()) != null) {
								do {
									if (!parentTx.isReadOnly()) {
										throw new IllegalStateException(
												"FileService.save() called from within a command (likely produces a deadlock)"); //$NON-NLS-1$
									}
								} while ((parentTx = ((TransactionalEditingDomainImpl) editingDomain).getActiveTransaction().getParent()) != null);
							}

							final EList<Resource> resources = editingDomain.getResourceSet().getResources();
							// Copy list to an array to prevent
							// ConcurrentModificationExceptions
							// during the saving of the dirty resources
							Resource[] resourcesArray = new Resource[resources.size()];
							resourcesArray = resources.toArray(resourcesArray);
							final Set<Resource> savedResources = new HashSet<Resource>();
							for (int i = 0; i < resourcesArray.length; i++) {
								// In case resource modification tracking is
								// switched on, we can check if a resource
								// has been modified, so that we only need to same
								// really changed resources; otherwise
								// we need to save all resources in the set
								final Resource resource = resourcesArray[i];
								if (resource.isModified()) {
									try {
										resource.save(options.get(resource));
										savedResources.add(resource);
									} catch (final Throwable t) {
										failedSaves.put(resource.getURI(), t);
									}
								}
							}
						}
					};

					try {
						editingDomain.runExclusive(runnable);
					} catch (final InterruptedException e) {
						throw new RuntimeException(e);
					}
					editingDomain.getCommandStack().flush();
				}
			};
			try {
				ResourcesPlugin.getWorkspace().run(wsRunnable, null);
				if (!failedSaves.isEmpty()) {
					throw new WrappedException(createMessage(failedSaves), new RuntimeException());
				}
			} catch (final CoreException e) {
				final Throwable cause = e.getStatus().getException();
				if (cause instanceof RuntimeException) {
					throw (RuntimeException) cause;
				}
				throw new RuntimeException(e);
			}
		}

		private static String createMessage(Map<URI, Throwable> failedSaves) {
//			final StringBuilder buf = new StringBuilder(Messages.FileService_ErrorMessageStart);
//			for (final Entry<URI, Throwable> entry : failedSaves.entrySet()) {
//				buf.append(Messages.FileService_ErrorMessageUri).append(entry.getKey().toString()).append(Messages.FileService_ErrorMessageCause).append(getExceptionAsString(entry.getValue()));
//			}
//			return buf.toString();
			return "Ërror Message";
		}

		private static String getExceptionAsString(Throwable t) {
			final StringWriter stringWriter = new StringWriter();
			final PrintWriter printWriter = new PrintWriter(stringWriter);
			t.printStackTrace(printWriter);
			final String result = stringWriter.toString();
			try {
				stringWriter.close();
			} catch (final IOException e) {
				// $JL-EXC$ ignore
			}
			printWriter.close();
			return result;
		}
}
