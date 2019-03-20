package github.trending.interactor

import com.nhaarman.mockito_kotlin.whenever
import github.trending.executor.PostExecutionThread
import github.trending.interactor.browse.GetProjects
import github.trending.models.Project
import github.trending.repository.ProjectsRepository
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetProjectsTest {
    private lateinit var getProjects: GetProjects
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread : PostExecutionThread

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(projectsRepository,postExecutionThread)
    }

    @Test
    fun getProjectsCompletes(){

    }

    private fun stubGetProjects(observable: Observable<List<Project>>){
        whenever(projectsRepository.getProjects())
            .thenReturn(observable)
    }


}