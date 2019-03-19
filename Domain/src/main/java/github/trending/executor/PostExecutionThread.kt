package github.trending.executor

import io.reactivex.Scheduler

interface PostExecutionThread{
    val scheduler: Scheduler
}