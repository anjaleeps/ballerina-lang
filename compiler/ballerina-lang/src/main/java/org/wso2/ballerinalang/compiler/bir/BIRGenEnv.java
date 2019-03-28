/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.ballerinalang.compiler.bir;

import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRBasicBlock;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRFunction;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRGlobalVariableDcl;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRPackage;
import org.wso2.ballerinalang.compiler.bir.model.BIRNode.BIRVariableDcl;
import org.wso2.ballerinalang.compiler.bir.model.BIROperand;
import org.wso2.ballerinalang.compiler.semantics.model.symbols.BSymbol;
import org.wso2.ballerinalang.compiler.util.Name;
import org.wso2.ballerinalang.compiler.util.Names;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores the state such as the current node, enclosing package, function etc, during bir generation.
 *
 * @since 0.980.0
 */
class BIRGenEnv {

    BIRPackage enclPkg;

    BIRFunction enclFunc;
    // This is a cache which can be stored inside the BIRFunction
    Map<BSymbol, BIRVariableDcl> symbolVarMap = new HashMap<>();
    // This is a global variable cache
    Map<BSymbol, BIRGlobalVariableDcl> globalVarMap = new HashMap<>();
    private int currentBBId = -1;
    private int currentLocalVarId = -1;
    private int currentGlobalVarId = -1;

    BIRBasicBlock enclBB;
    BIRBasicBlock trapBB;
    BIROperand targetOperand;

    // This is the basic block that contains the return instruction for the current function.
    // A function can have only one basic block that has a return instruction.
    BIRBasicBlock returnBB;

    BIRGenEnv(BIRPackage birPkg) {
        this.enclPkg = birPkg;
    }

    Name nextBBId(Names names) {
        currentBBId++;
        return names.merge(Names.BIR_BASIC_BLOCK_PREFIX, names.fromString(Integer.toString(currentBBId)));
    }

    Name nextLocalVarId(Names names) {
        currentLocalVarId++;
        return names.merge(Names.BIR_LOCAL_VAR_PREFIX, names.fromString(Integer.toString(currentLocalVarId)));
    }

    Name nextGlobalVarId(Names names) {
        currentGlobalVarId++;
        return names.merge(Names.BIR_GLOBAL_VAR_PREFIX, names.fromString(Integer.toString(currentGlobalVarId)));
    }

    void clear() {
        this.symbolVarMap.clear();
        this.currentLocalVarId = -1;
        this.currentBBId = -1;
        this.targetOperand = null;
        this.enclBB = null;
        this.returnBB = null;
        this.enclFunc = null;
    }
}
