package org.nd4j.linalg.nativ;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.nd4j.linalg.BaseNd4jTest;
import org.nd4j.linalg.api.ops.DynamicCustomOp;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;
import org.nd4j.nativeblas.NativeOps;

import static org.junit.Assert.assertEquals;

/**
 * This class contains tests related to javacpp presets and their libnd4j integration
 * @author raver119@gmail.com
 */
@Slf4j
public class NativeBlasTests extends BaseNd4jTest {

    public NativeBlasTests(Nd4jBackend backend) {
        super(backend);
    }

    @Before
    public void setUp() {
        //Nd4j.getExecutioner()
    }

    @Test
    public void testBlasGemm1() {

        // we're skipping blas here
        if (Nd4j.getExecutioner().getClass().getSimpleName().toLowerCase().contains("cuda"))
            return;

        val A = Nd4j.linspace(1, 9, 9).reshape('c', 3, 3);
        val B = Nd4j.linspace(1, 9, 9).reshape('c', 3, 3);

        val exp = A.mmul(B);

        val res = Nd4j.create(new int[] {3, 3}, 'c');

        val matmul = DynamicCustomOp.builder("matmul")
                .addInputs(A, B)
                .addOutputs(res)
                .build();

        Nd4j.getExecutioner().exec(matmul);

        assertEquals(exp, res);
    }

    @Override
    public char ordering() {
        return 'c';
    }
}
