package org.nd4j.linalg.nativ;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.nd4j.linalg.BaseNd4jTest;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;
import org.nd4j.nativeblas.NativeOps;

/**
 * This class contains tests related to javacpp presets and their libnd4j integration
 * @author raver119@gmail.com
 */
@Slf4j
public class NativeBlasTests extends BaseNd4jTest {

    public NativeBlasTests(Nd4jBackend backend) {
        super(backend);
    }

    @Test
    public void testBlasGemm1() {
        // we're skipping blas here
        if (Nd4j.getExecutioner().getClass().getSimpleName().toLowerCase().contains("cuda"))
            return;


    }

    @Override
    public char ordering() {
        return 'c';
    }
}
