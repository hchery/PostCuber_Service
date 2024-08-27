package cuber.post.app.sdk.utils;

/**
 * DATE: 2024/8/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
public abstract class IndexedChain<T extends IndexedChain<T>> {

    private boolean noSpringBean = false;
    private int index = 0;

    protected abstract T createChain();

    protected final void confirmNoSpringBean() {
        noSpringBean = true;
    }

    public T newChain() {
        T chain = createChain();
        chain.confirmNoSpringBean();
        return chain;
    }

    protected int getIndexAndIncrement() {
        if (noSpringBean) {
            return index++;
        }
        String message = "You need call 'newChain' method to create a new chain before use it";
        throw new IllegalStateException(message);
    }
}
