/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.transforms;

import org.apache.commons.math3.util.FastMath;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformOp;

import java.util.List;

/**
 * Stabilization function, forces values to be within a range
 *
 * @author Adam Gibson
 */
public class Stabilize extends BaseTransformOp {
    double realMin = 1.1755e-38f;
    double cutOff = FastMath.log(realMin);
    double k;

    public Stabilize(SameDiff sameDiff, DifferentialFunction i_v, boolean inPlace, double realMin, double cutOff, double k) {
        super(sameDiff, i_v, inPlace);
        this.realMin = realMin;
        this.cutOff = cutOff;
        this.k = k;
    }

    public Stabilize(SameDiff sameDiff, DifferentialFunction i_v, int[] shape, boolean inPlace, Object[] extraArgs, double realMin, double cutOff, double k) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
        this.realMin = realMin;
        this.cutOff = cutOff;
        this.k = k;
    }

    public Stabilize(SameDiff sameDiff, DifferentialFunction i_v, Object[] extraArgs, double realMin, double cutOff, double k) {
        super(sameDiff, i_v, extraArgs);
        this.realMin = realMin;
        this.cutOff = cutOff;
        this.k = k;
    }

    public Stabilize() {}

    public Stabilize(INDArray x, INDArray z, double k) {
        super(x, z);
        this.k = k;
    }

    public Stabilize(INDArray x, INDArray z, long n, double k) {
        super(x, z, n);
        this.k = k;
    }

    public Stabilize(INDArray x, INDArray y, INDArray z, long n, double k) {
        super(x, y, z, n);
        this.k = k;
    }

    public Stabilize(INDArray x, double k) {
        super(x);
        this.k = k;
    }

    @Override
    public int opNum() {
        return 28;
    }

    @Override
    public String opName() {
        return "stabilize";
    }

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }


    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> f1) {
        return null;
    }
}
