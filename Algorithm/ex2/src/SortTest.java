import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Sort Tester.
 *
 * @author Hanxy
 * @version 1.0.2
 * @since <pre>ʮ���� 9, 2017</pre>
 */
public class SortTest {

    private int arraysLength[] = {10, 20, 50, 100, 200, 1000, 2000, 5000, 10000};
//    private int arraysLength[] = {10, 20, 50, 100};
//    private int arraysLength[] = {100};

    private static final int MAX_VALUE = 1000;

    private static final int SELECTION_FLAG = 0;
    private static final int BUBBLE_FLAG = 1;
    private static final int INSERT_FLAG = 2;
    private static final int MERGE_FLAG = 3;
    private static final int QUICK_FLAG = 4;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectionSort(int[] a)
     */
    @Test
    public void testSelectionSort() throws Exception {
//TODO: Test goes here...
        System.out.println("����ѡ������");
        testRandomArray(SELECTION_FLAG);
        testSortedArray(SELECTION_FLAG);
        testReversedArray(SELECTION_FLAG);
    }

    /**
     * Method: bubbleSort(int[] a)
     */
    @Test
    public void testBubbleSort() throws Exception {
//TODO: Test goes here...

        System.out.println("����ð������");
        testRandomArray(BUBBLE_FLAG);
        testSortedArray(BUBBLE_FLAG);
        testReversedArray(BUBBLE_FLAG);
    }

    /**
     * Method: insertSort(int[] a)
     */
    @Test
    public void testInsertSort() throws Exception {
//TODO: Test goes here...
        System.out.println("���Բ�������");
        testRandomArray(INSERT_FLAG);
        testSortedArray(INSERT_FLAG);
        testReversedArray(INSERT_FLAG);
    }

    /**
     * Method: mergeSort(int[] a)
     */
    @Test
    public void testMergeSort() throws Exception {
//TODO: Test goes here...
        System.out.println("���Թ鲢����");
        testRandomArray(MERGE_FLAG);
        testSortedArray(MERGE_FLAG);
        testReversedArray(MERGE_FLAG);
    }

    /**
     * Method: quickSort(int[] a)
     */
    @Test
    public void testQuickSort() throws Exception {
//TODO: Test goes here...
        System.out.println("���Կ�������");
        testRandomArray(QUICK_FLAG);
        testSortedArray(QUICK_FLAG);
        testReversedArray(QUICK_FLAG);
    }

    /**
     * ���ݲ�ͬ�㷨���������������ʱ��
     *
     * @param flag �㷨��־
     */
    private void testRandomArray(int flag) {
        long runingTime = 0;

        /********************�����������**********************/
        System.out.println("�����������");
        for (int i = 0; i < arraysLength.length; i++) {
            int length = arraysLength[i];

            System.out.println("���Գ���Ϊ" + length + "������");
            System.out.println("������ɲ�������...");
            int[] a = generateTestArray(length, MAX_VALUE);
            System.out.println("�ɹ����ɲ�������");
            System.out.println("����Ԥ�ڽ������...");
            int[] b = generateExpectedArray(a);
            System.out.println("�ɹ�����Ԥ�ڽ������");

            System.out.println("ִ������");

            runingTime = testArray(a, flag);
            assertArrayEquals(b, a);
            System.out.println("����ʱ��Ϊ��" + runingTime + "ns");
        }
    }

    /**
     * ���ݲ�ͬ�㷨����˳����������ʱ��
     *
     * @param flag �㷨��־
     */
    private void testSortedArray(int flag){
        long runingTime = 0;

        /********************����˳������**********************/
        System.out.println("����˳������");
        for (int i = 0; i < arraysLength.length; i++) {
            int length = arraysLength[i];

            System.out.println("���Գ���Ϊ" + length + "������");
            System.out.println("����˳���������...");
            int[] a = generateTestArray(length, MAX_VALUE);
            Arrays.sort(a);
            System.out.println("�ɹ����ɲ�������");
            System.out.println("����Ԥ�ڽ������...");
            int[] b = generateExpectedArray(a);
            System.out.println("�ɹ�����Ԥ�ڽ������");

            System.out.println("ִ������");

            runingTime = testArray(a, flag);
            assertArrayEquals(b, a);
            System.out.println("����ʱ��Ϊ��" + runingTime + "ns");
        }
    }

    /**
     * ���ݲ�ͬ�㷨����������������ʱ��
     *
     * @param flag �㷨��־
     */
    private void testReversedArray(int flag){
        long runingTime = 0;

        /********************������������**********************/
        System.out.println("������������");
        for (int i = 0; i < arraysLength.length; i++) {
            int length = arraysLength[i];

            System.out.println("���Գ���Ϊ" + length + "������");
            System.out.println("���������������...");
            int[] a = generateTestArray(length, MAX_VALUE);
            Arrays.sort(a);
            reverse(a);
            System.out.println("�ɹ����ɲ�������");
            System.out.println("����Ԥ�ڽ������...");
            int[] b = generateExpectedArray(a);
            System.out.println("�ɹ�����Ԥ�ڽ������");
            System.out.println("ִ������");
            runingTime = testArray(a, flag);
            assertArrayEquals(b, a);
            System.out.println("����ʱ��Ϊ��" + runingTime + "ns");
        }
    }

    /**
     * ʹ��������
     *
     * @param a ����
     */
    private void reverse(int[] a){

        for (int i = 0; i < a.length; i++){
            a[i] = -a[i];
        }

    }

    /**
     * ���ݲ�ͬ�㷨������������ʱ��
     *
     * @param a ��������
     * @param flag �㷨��־
     * @return ����ʱ��
     */
    private long testArray(int[] a, int flag) {
        long startTime = 0;
        long endTime = 0;

        switch (flag) {
            case SELECTION_FLAG:
                startTime = System.nanoTime();
                Sort.selectionSort(a);
                endTime = System.nanoTime();
                break;
            case BUBBLE_FLAG:
                startTime = System.nanoTime();
                Sort.bubbleSort(a);
                endTime = System.nanoTime();
                break;
            case INSERT_FLAG:
                startTime = System.nanoTime();
                Sort.insertSort(a);
                endTime = System.nanoTime();
                break;
            case MERGE_FLAG:
                startTime = System.nanoTime();
                Sort.mergeSort(a);
                endTime = System.nanoTime();
                break;
            case QUICK_FLAG:
                startTime = System.nanoTime();
                Sort.quickSort(a);
                endTime = System.nanoTime();
                break;
            default:
                System.err.println("��������򷽷�");
                return 0;
        }
        return endTime - startTime;

    }

    /**
     * output a array
     *
     * @param a the array to output
     */
    private void outputArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * randomly generate array between -maxData and maxData
     *
     * @param length  the length of the array
     * @param maxData the max value of the array
     * @return the random array
     */
    private int[] generateTestArray(int length, int maxData) {
        int a[] = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = new Random().nextInt(maxData * 2) - maxData;
        }

        return a;
    }


    /**
     * generate expected sorted array
     *
     * @param a the test array
     * @return b the expected sorted array
     */
    private int[] generateExpectedArray(int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);
        return b;
    }

} 
