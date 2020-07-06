module io.ballerina.lang {
    requires java.compiler;
    requires org.apache.commons.lang3;
    requires toml4j;
    requires gson;
    requires java.xml;
    requires org.objectweb.asm;
    requires io.ballerina.jvm;
    requires io.netty.buffer;
    requires antlr4.runtime;
    requires io.ballerina.cli.module;
    exports org.wso2.ballerinalang.compiler.util;
    exports org.ballerinalang.toml.model;
    exports org.wso2.ballerinalang.util;
    exports org.ballerinalang.model.types;
    exports org.wso2.ballerinalang.compiler.tree;
    exports org.wso2.ballerinalang.compiler.tree.types;
    exports org.ballerinalang.compiler;
    exports org.ballerinalang.compiler.plugins;
    exports org.ballerinalang.model.tree;
    exports org.ballerinalang.model.elements;
    exports org.ballerinalang.util.diagnostic;
    exports org.wso2.ballerinalang.compiler.semantics.model.types;
    exports org.wso2.ballerinalang.compiler.semantics.model.symbols;
    exports org.wso2.ballerinalang.compiler.tree.expressions;
    exports org.ballerinalang.model.tree.expressions;
    exports org.wso2.ballerinalang.compiler.util.diagnotic;
    exports org.ballerinalang.natives.annotations;
    exports org.wso2.ballerinalang.compiler.semantics.analyzer;
    exports org.wso2.ballerinalang.compiler.semantics.model;
    exports org.ballerinalang.model;
    exports org.wso2.ballerinalang.compiler.desugar;
    exports org.ballerinalang.model.tree.statements;
    exports org.wso2.ballerinalang.compiler.tree.statements;
    exports org.ballerinalang.annotation;
    exports org.ballerinalang.codegen;
    exports org.ballerinalang.spi;
    exports org.wso2.ballerinalang.compiler;
    exports org.wso2.ballerinalang.programfile;
    exports org.ballerinalang.toml.parser;
    exports org.ballerinalang.repository;
    exports org.wso2.ballerinalang.compiler.packaging;
    exports org.wso2.ballerinalang.compiler.packaging.converters;
    exports org.wso2.ballerinalang.compiler.packaging.repo;
    exports org.wso2.ballerinalang.compiler.bir;
    exports org.ballerinalang.toml.exceptions;
    exports org.ballerinalang.model.tree.types;
    exports org.wso2.ballerinalang.compiler.parser.antlr4;
    exports org.wso2.ballerinalang.compiler.parser;
    exports org.ballerinalang.model.symbols;
    exports org.ballerinalang.repository.fs;
    exports org.wso2.ballerinalang.compiler.spi;
}