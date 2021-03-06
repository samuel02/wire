// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: edge_cases.proto
package com.squareup.wire.protos.kotlin.edgecases

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.hashCode
import kotlin.jvm.JvmField
import okio.ByteString

class OneField(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  val opt_int32: Int? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<OneField, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is OneField) return false
    if (unknownFields != other.unknownFields) return false
    if (opt_int32 != other.opt_int32) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + opt_int32.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (opt_int32 != null) result += """opt_int32=$opt_int32"""
    return result.joinToString(prefix = "OneField{", separator = ", ", postfix = "}")
  }

  fun copy(opt_int32: Int? = this.opt_int32, unknownFields: ByteString = this.unknownFields):
      OneField = OneField(opt_int32, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<OneField> = object : ProtoAdapter<OneField>(
      FieldEncoding.LENGTH_DELIMITED, 
      OneField::class, 
      "type.googleapis.com/squareup.protos.kotlin.edgecases.OneField"
    ) {
      override fun encodedSize(value: OneField): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.opt_int32)
        return size
      }

      override fun encode(writer: ProtoWriter, value: OneField) {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.opt_int32)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): OneField {
        var opt_int32: Int? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> opt_int32 = ProtoAdapter.INT32.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return OneField(
          opt_int32 = opt_int32,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: OneField): OneField = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
