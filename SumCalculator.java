import java.util.*;
public class SumCalculator 
{
    public static void main(String[] args) 
    {
        List<Integer> numbers = Arrays.asList(parseInt("10"), parseInt("20"), parseInt("30"));
        int sum = calculateSum(numbers);
        System.out.println("Sum: " + sum);
    }
    public static Integer parseInt(String str) //22BCS16387
    {
        return Integer.parseInt(str);
    }
    public static int calculateSum(List<Integer> numbers) 
    {
        int sum = 0;
        for (Integer num : numbers) 
        {
            sum += num;
        }
        return sum;
    }
}
