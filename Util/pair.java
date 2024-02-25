package Util;

import java.util.Objects;

class pair<T> {
    T x,y;

    public pair(T x,T y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }

        if(o==null||o.getClass()!=getClass()){
            return false;
        }
        pair<T> tmp = (pair<T>) o;
        return tmp.x==x && tmp.y==y;
    }
}
