package Chapter12_CollectionFW.No1_Generic;

public class Point<T, V> {
    T x;
    V y;
    
    Point(T x, V y) {
        this.x = x;
        this.y = y;
    }
    
    // 이하 제네릭 메서드
    
    public T getX() {
        return x;
    }
    
    public V getY() {
        return y;
    }
}
