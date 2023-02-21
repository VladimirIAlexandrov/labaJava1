import java.util.ArrayList;


public class RecIntegral {


    ArrayList<Double> dataList = new ArrayList<Double>();

    private static int counter;
    public RecIntegral(){
        counter++;
    }

    /////////////////////////////////СЕТЫ///////////////////////////////////
    public void setDataA(Double dataA) {
        dataList.add(0, dataA);
    }
    public void setDataB(Double dataB) {

        dataList.add(1, dataB);

    }
    public void setDataC(Double dataC) {

        dataList.add(2, dataC);

    }
    public void setDataD(Double dataD) {

        dataList.add(3, dataD);

    }
    //////////////////////////////ГЕТЫ////////////////////////////////////////
    public Double[] getDataList() {
        Double[] dblArray = new Double[dataList.size()];
        dblArray = dataList.toArray(dblArray);
        return dblArray;
    }
    public Double getDataA() {
        return dataList.get(0);
    }
    public Double getDataB() {
        return dataList.get(1);
    }
    public Double getDataC() {
        return dataList.get(2);
    }
    public Double getDataD() {
        return dataList.get(3);
    }
    public static int getCount() {
        return counter;
    }

    public void clearObject() {

        setDataA(null);
        setDataB(null);
        setDataC(null);
        setDataD(null);
    }


    //////////////////////////////ВЫЧИСЛЕНИЯ////////////////////////////////////////
    private static double InFunction(double x) //Подынтегральная функция
    {
        return 1/(Math.log(x));
    }

    public void Trap(){
        double result=0;
        int n = (int)((getDataA()-getDataB())/getDataC());
        result += (InFunction(getDataA())+InFunction(getDataB()))/2;
        for(int i = 1; i < n; i++) {
            result += InFunction(getDataB() + getDataC() * i);
        }
        setDataD(getDataC()*result);
    }


}
