// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: routeguide/RouteGuideProto.proto
package routeguide

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_2
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

/**
 * A latitude-longitude rectangle, represented as two diagonally opposite
 * points "lo" and "hi".
 */
class Rectangle(
  /**
   * One corner of the rectangle.
   */
  @field:WireField(
    tag = 1,
    adapter = "routeguide.Point#ADAPTER"
  )
  val lo: Point? = null,
  /**
   * The other corner of the rectangle.
   */
  @field:WireField(
    tag = 2,
    adapter = "routeguide.Point#ADAPTER"
  )
  val hi: Point? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Rectangle, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Rectangle) return false
    if (unknownFields != other.unknownFields) return false
    if (lo != other.lo) return false
    if (hi != other.hi) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + lo.hashCode()
      result = result * 37 + hi.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (lo != null) result += """lo=$lo"""
    if (hi != null) result += """hi=$hi"""
    return result.joinToString(prefix = "Rectangle{", separator = ", ", postfix = "}")
  }

  fun copy(
    lo: Point? = this.lo,
    hi: Point? = this.hi,
    unknownFields: ByteString = this.unknownFields
  ): Rectangle = Rectangle(lo, hi, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Rectangle> = object : ProtoAdapter<Rectangle>(
      FieldEncoding.LENGTH_DELIMITED, 
      Rectangle::class, 
      "type.googleapis.com/routeguide.Rectangle", 
      PROTO_2
    ) {
      override fun encodedSize(value: Rectangle): Int {
        var size = value.unknownFields.size
        size += Point.ADAPTER.encodedSizeWithTag(1, value.lo)
        size += Point.ADAPTER.encodedSizeWithTag(2, value.hi)
        return size
      }

      override fun encode(writer: ProtoWriter, value: Rectangle) {
        Point.ADAPTER.encodeWithTag(writer, 1, value.lo)
        Point.ADAPTER.encodeWithTag(writer, 2, value.hi)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Rectangle {
        var lo: Point? = null
        var hi: Point? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> lo = Point.ADAPTER.decode(reader)
            2 -> hi = Point.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Rectangle(
          lo = lo,
          hi = hi,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Rectangle): Rectangle = value.copy(
        lo = value.lo?.let(Point.ADAPTER::redact),
        hi = value.hi?.let(Point.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
