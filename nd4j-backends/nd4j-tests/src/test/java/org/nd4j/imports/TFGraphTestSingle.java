package org.nd4j.imports;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.io.ClassPathResource;

import java.util.Map;

import static org.nd4j.imports.TFGraphTestAll.inputVars;
import static org.nd4j.imports.TFGraphTestAll.outputVars;
import static org.nd4j.imports.TFGraphTestAll.testSingle;

/**
 * TFGraphTestAll will run all the checked in TF graphs and
 *      compare outputs in nd4j to those generated and checked in from TF.
 *
 * This file is to run a single graph that is checked in to aid in debug.
 * Simply change the modelName String in testOne() to correspond to the directory name the graph lives in
 *  - eg. to run the graph for 'bias_add' i.e checked in under tf_graphs/examples/bias_add
 *  set modelName to "bias_add"
 *
 */
@Slf4j
public class TFGraphTestSingle {

    @Test
    public void testOne() throws  Exception {
        //String modelName = "bias_add";
        //String modelName = "conv_0";
        //String modelName = "transform_0";
        String modelName = "ae_00";
        String modelDir = new ClassPathResource("tf_graphs/examples/" + modelName).getFile().getAbsolutePath();
        Map<String, INDArray> inputs = inputVars(modelDir);
        Map<String, INDArray> predictions = outputVars(modelDir);
        testSingle(inputs,predictions,modelName,modelDir);
    }
}
