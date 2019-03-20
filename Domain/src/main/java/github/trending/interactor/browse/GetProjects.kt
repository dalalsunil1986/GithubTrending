package github.trending.interactor.browse

import github.trending.executor.PostExecutionThread
import github.trending.interactor.ObservableUseCase
import github.trending.models.Project
import github.trending.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetProjects @Inject constructor(private val projectsRepository: ProjectsRepository, postExecutionThread: PostExecutionThread)
    :ObservableUseCase<List<Project>,Nothing?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }
}