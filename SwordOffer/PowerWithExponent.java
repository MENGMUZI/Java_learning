/**
 * @author : mengmuzi
 * create at:  2019-03-20  17:14
 * @description: 数值的整数次方
 */
public class PowerWithExponent {

    public double powerWithExponent(double base , int exponent){
        if(base ==0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        if(exponent == -1){
            return 1/base;
        }
        double result = powerWithExponent(base,exponent >> 1);
        result *= result;
        if((exponent & 0x1) ==1){ //2个地方都用位运算，可以提高运算的效率
            result *=base;
        }
        return result;

    }

}
