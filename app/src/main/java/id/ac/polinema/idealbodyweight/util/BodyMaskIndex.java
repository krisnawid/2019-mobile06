package id.ac.polinema.idealbodyweight.util;

public class BodyMaskIndex {

    private float mass;
    private float height;
    private float index;


    public BodyMaskIndex(float mass, float height) {
        this.mass = mass;
        this.height = height/100;
        this.index = calculate();
    }

    public float getIndex() {
        return index;
    }

    private float calculate() {
        float hasil = (float) (this.mass/Math.pow(this.height, 2));
        return hasil;
    }

}
