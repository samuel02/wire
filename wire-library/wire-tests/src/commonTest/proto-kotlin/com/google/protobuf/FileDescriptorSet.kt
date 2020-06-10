// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import com.squareup.wire.internal.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * The protocol compiler can output a FileDescriptorSet containing the .proto
 * files it parses.
 */
class FileDescriptorSet(
  @field:WireField(
    tag = 1,
    adapter = "com.google.protobuf.FileDescriptorProto#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val file: List<FileDescriptorProto> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<FileDescriptorSet, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is FileDescriptorSet) return false
    if (unknownFields != other.unknownFields) return false
    if (file != other.file) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + file.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (file.isNotEmpty()) result += """file=$file"""
    return result.joinToString(prefix = "FileDescriptorSet{", separator = ", ", postfix = "}")
  }

  fun copy(file: List<FileDescriptorProto> = this.file, unknownFields: ByteString =
      this.unknownFields): FileDescriptorSet = FileDescriptorSet(file, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<FileDescriptorSet> = object : ProtoAdapter<FileDescriptorSet>(
      FieldEncoding.LENGTH_DELIMITED, 
      FileDescriptorSet::class, 
      "type.googleapis.com/google.protobuf.FileDescriptorSet", 
      PROTO_2
    ) {
      override fun encodedSize(value: FileDescriptorSet): Int {
        var size = value.unknownFields.size
        size += FileDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(1, value.file)
        return size
      }

      override fun encode(writer: ProtoWriter, value: FileDescriptorSet) {
        FileDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.file)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): FileDescriptorSet {
        val file = mutableListOf<FileDescriptorProto>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> file.add(FileDescriptorProto.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return FileDescriptorSet(
          file = file,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: FileDescriptorSet): FileDescriptorSet = value.copy(
        file = value.file.redactElements(FileDescriptorProto.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
