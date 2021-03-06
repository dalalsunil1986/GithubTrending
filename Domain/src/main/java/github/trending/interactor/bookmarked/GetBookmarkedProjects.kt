package github.trending.interactor.bookmarked

import github.trending.executor.PostExecutionThread
import github.trending.interactor.ObservableUseCase
import github.trending.models.Project
import github.trending.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetBookmarkedProjects @Inject constructor(private val projectsRepository: ProjectsRepository,postExecutionThread: PostExecutionThread)
    :ObservableUseCase<List<Project>,Nothing?>(postExecutionThread){
    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}