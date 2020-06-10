// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: single_level.proto
package com.squareup.wire.protos.single_level;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Foo extends Message<Foo, Foo.Builder> {
  public static final ProtoAdapter<Foo> ADAPTER = new ProtoAdapter_Foo();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_BAR = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer bar;

  public Foo(Integer bar) {
    this(bar, ByteString.EMPTY);
  }

  public Foo(Integer bar, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.bar = bar;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.bar = bar;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Foo)) return false;
    Foo o = (Foo) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(bar, o.bar);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (bar != null ? bar.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (bar != null) builder.append(", bar=").append(bar);
    return builder.replace(0, 2, "Foo{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Foo, Builder> {
    public Integer bar;

    public Builder() {
    }

    public Builder bar(Integer bar) {
      this.bar = bar;
      return this;
    }

    @Override
    public Foo build() {
      return new Foo(bar, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Foo extends ProtoAdapter<Foo> {
    public ProtoAdapter_Foo() {
      super(FieldEncoding.LENGTH_DELIMITED, Foo.class, "type.googleapis.com/single_level.Foo", Syntax.PROTO_2);
    }

    @Override
    public int encodedSize(Foo value) {
      return ProtoAdapter.INT32.encodedSizeWithTag(1, value.bar)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Foo value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.bar);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Foo decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.bar(ProtoAdapter.INT32.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public Foo redact(Foo value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
