package github.trending.interactor.bookmark

import com.nhaarman.mockito_kotlin.whenever
import github.trending.executor.PostExecutionThread
import github.trending.interactor.bookmarked.GetBookmarkedProjects
import github.trending.models.Project
import github.trending.repository.ProjectsRepository
import github.trending.test.ProjectDataFactory
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetBookmarkedProjectsTest {
    private lateinit var getBookmarkedProject: GetBookmarkedProjects
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        getBookmarkedProject = GetBookmarkedProjects(projectsRepository,postExecutionThread)
    }

    @Test
    fun getBookmarkedProjectsCompletes(){
        val projects = ProjectDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))

        val testObserver = getBookmarkedProject.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBookmarkedProjectsReturnsData(){
        val projects = ProjectDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))

        val testObserver = getBookmarkedProject.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Project>>){
        whenever(projectsRepository.getBookmarkedProjects())
            .thenReturn(observable)
    }
}