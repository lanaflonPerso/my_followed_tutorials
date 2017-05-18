## Reactor的类型
Reactor有两种类型， Flux<T> 和 Mono<T> 。Flux类似RaxJava的Observable，它可以触发零到多个事件，并根据实际情况结束处理或触发错误。

Mono最多只触发一个事件，它跟RxJava的 Single 和 Maybe 类似，所以可以把Mono<Void>用于在异步任务完成时发出通知。

因为这两种类型之间的简单区别，我们可以很容易地区分响应式API的类型：从返回的类型我们就可以知道一个方法会“发射并忘记”或“请求并等待”（Mono），还是在处理一个包含多个数据项的流（Flux）。

Flux和Mono的一些操作利用了这个特点在这两种类型间互相转换。例如，调用Flux<T>的single()方法将返回一个Mono<T>，而使用concatWith()方法把两个Mono串在一起就可以得到一个Flux。类似地，有些操作对Mono来说毫无意义（例如take(n)会得到n>1的结果），而有些操作只有作用在Mono上才有意义（例如or(otherMono)）。

Reactor设计的原则之一是要保持API的精简，而对这两种响应式类型的分离，是表现力与API易用性之间的折中。

### Relevant articles

- [Intro To Reactor Core](http://www.baeldung.com/reactor-core)

