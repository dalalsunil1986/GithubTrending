package github.trending.interactor.bookmarked

import github.trending.executor.PostExecutionThread
import github.trending.interactor.CompletableUseCase
import github.trending.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

open class BookmarkProject @Inject constructor(private val projectsRepository: ProjectsRepository,postExecutionThread: PostExecutionThread):
CompletableUseCase<BookmarkProject.Params>(postExecutionThread){
    override fun buildUseCaseCompletable(params: Params?): Completable {
        if(params==null) throw IllegalAccessException("Params can't be null")
        return projectsRepository.bookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String){
        companion object {
            fun forProject(projectId: String): Params{
                return Params(projectId)
            }
        }
    }
}