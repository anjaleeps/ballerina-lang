/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package io.ballerina.compiler.internal.diagnostics;

import io.ballerina.tools.diagnostics.DiagnosticCode;
import io.ballerina.tools.diagnostics.DiagnosticSeverity;

/**
 * Represents a diagnostic warning code.
 *
 * @since 2.0.0
 */
public enum DiagnosticWarningCode implements DiagnosticCode {
    WARNING_INVALID_BALLERINA_NAME_REFERENCE("BCE10000", "warning.invalid.ballerina.name.reference"),
    WARNING_CANNOT_HAVE_DOCUMENTATION_INLINE_WITH_A_CODE_REFERENCE_BLOCK("BCE10001",
            "warning.cannot.have.documentation.inline.with.a.code.reference.block"),
    WARNING_INLINE_CODE_REFERENCE_NOT_ENDED_WITH_BACKTICKS("BCE10002",
            "warning.inline.code.reference.not.ended.with.backticks"),
    ;

    String diagnosticId;
    String messageKey;

    DiagnosticWarningCode(String diagnosticId, String messageKey) {
        this.diagnosticId = diagnosticId;
        this.messageKey = messageKey;
    }

    @Override
    public DiagnosticSeverity severity() {
        return DiagnosticSeverity.WARNING;
    }

    @Override
    public String diagnosticId() {
        return diagnosticId;
    }

    @Override
    public String messageKey() {
        return messageKey;
    }

    public boolean equals(DiagnosticCode code) {
        return this.messageKey.equals(code.messageKey());
    }
}
