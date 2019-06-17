package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item73
 * @description: 抛出与抽象对应的异常
 * 如果方法抛出的异常与它所执行的任务没有明显的关系，这种情况会使得客户端不知所措。当方法床底由底层抽象抛出的异常时，往往会发生这种情况，除了使人困惑，也会污染了具有实现细节的更高层的API。
 * 为了避免这个问题，更高层的实现应该捕获低层的异常，同时抛出可以按照高层抽象进行解释的异常。这种做法称为异常转译。
 * try{
 * ···//use lower-level abstraction to do bidding
 * }catch(lowerLevel Exception e){
 * throw new HigherLevelException()
 * }
 * 一种特殊的异常转译形式称为异常链（exception chaining）,如果低层的异常对于调试高层异常的问题非常有帮助，那使用异常链就很适合。
 * 低层的异常被传到高层的因此韩，高层的异常提供访问方法（Throwable的getCause（））来获取低层的异常
 * try{
 *     ···//use lower-level abstraction to do bidding
 * }catch(LowerLevelException cause){
 *     throw new HigherLevelException(cause);
 * }
 * 大多数标准的异常都有支持链的构造器，对于没有支持链的异常，可以利用Throwable的initCause方法设置原因。异常链不仅可以使用getCause访问原因，还有可以将原因的堆栈轨迹集成到更高层的异常中。
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item73 {
}
