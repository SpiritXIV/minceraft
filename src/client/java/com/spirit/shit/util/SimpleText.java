package com.spirit.shit.util;

import net.minecraft.text.*;

import java.util.List;
import java.util.Optional;
import java.util.Collections;


public class SimpleText implements Text {
    private final TextContent content;
    public SimpleText(TextContent content) {
        this.content = content;
    }

    @Override
    public TextContent getContent() {
        return content;
    }

    @Override
    public String asTruncatedString(int length) {
        return Text.super.asTruncatedString(length);
    }

    @Override
    public List<Text> getSiblings() {
        return Collections.emptyList(); // No siblings for simplicity
    }

    @Override
    public OrderedText asOrderedText() {
        return null;
    }

    @Override
    public <T> Optional<T> visit(StyledVisitor<T> styledVisitor, Style style) {
        return Text.super.visit(styledVisitor, style);
    }

    @Override
    public <T> Optional<T> visit(Visitor<T> visitor) {
        return Text.super.visit(visitor);
    }

    @Override
    public List<Text> getWithStyle(Style style) {
        return Text.super.getWithStyle(style);
    }

    @Override
    public boolean contains(Text text) {
        return Text.super.contains(text);
    }

    @Override
    public Style getStyle() {
        return Style.EMPTY;
    }
}
