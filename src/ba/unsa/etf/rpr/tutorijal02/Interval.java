package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double x,y;
    boolean x1, x2;
    Interval (double x, double y, boolean x1, boolean x2) {
        if (x > y) throw new IllegalArgumentException("Cannot locate readable file ");
        this.x = x;
        this.y = y;
        this.x1=x1;
        this.x2=x2;
    }
    Interval () {
        x= 0;
        y=0;
        x1=false;
        x2= false;

    }



    @Override
    public String toString() {
        String k ="";
        if (x1==true) k+="["; else  k+="(";
        if (x!=0 || y!=0) k+=x+","+y;
        if (x2==true) k+="]"; else  k+=")";
        return k.toString();
    }

    public boolean isIn (double t) {
        if (x1== true) {
            if (t<x) return false;
        }
        else if (t<=x) return false;

        if (x2== true) {
            if (t>y) return false;
        }
        else if (t>=y) return false;
        return true;

    }

    public boolean isNull () {
        if( x == y) return true;
        return false;

    }

    public Interval intersect (Interval i) {
        double p = 0;
        double q = 0;
        boolean t= true;
        boolean f = true;
        if (i.x>this.x && i.x<this.y) {   p = i.x; t=i.x1;  }
        if (i.y>this.x && i.y<this.y) {   q = i.y; f = i.x2; }
        if (this.x>i.x && this.x<i.y) {   p = this.x; t=this.x1; }
        if (this.y>i.x && this.y<i.y) {   q = this.y;   f = this.x2; }
    //    if (x ==0 && y ==0) { return  }
        return new Interval(p, q, t, f );
    }

    static Interval intersect (Interval i1, Interval i2) {
        return i1.intersect(i2);
    }

    boolean equals(Interval i) {
        return i.x == x && i.y == y &&  i.x1 == x1 && i.x2==x2;
    }



}
