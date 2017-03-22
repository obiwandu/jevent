package event;

/**
 * Created by obiwan on 2017/3/22.
 */
/**
 * 一个EventEmitter能为某个事件注册监听器，或发出某个事件的通知
 */
public interface EventEmitter {
    /**
     * 为事件注册监听器
     * @param eventName 事件名
     * @param handler
     */
    public void on(String eventName, EventHandler handler);

    /**
     * 发出某个事件的通知
     * @param eventName 事件名
     * @param args
     */
    public void emit(String eventName, Object ... args);

    /**
     * 移除该事件的所有监听器
     * @param eventName
     */
    public void remove(String eventName);
}
