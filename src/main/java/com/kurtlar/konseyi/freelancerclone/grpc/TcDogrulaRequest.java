// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/resources/TcDogrula.proto

// Protobuf Java Version: 3.25.1
package com.kurtlar.konseyi.freelancerclone.grpc;

/**
 * Protobuf type {@code com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest}
 */
public final class TcDogrulaRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)
    TcDogrulaRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TcDogrulaRequest.newBuilder() to construct.
  private TcDogrulaRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TcDogrulaRequest() {
    tCKimlikNo_ = "";
    ad_ = "";
    soyad_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TcDogrulaRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrula.internal_static_com_kurtlar_konseyi_freelancerclone_grpc_TcDogrulaRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrula.internal_static_com_kurtlar_konseyi_freelancerclone_grpc_TcDogrulaRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.class, com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.Builder.class);
  }

  public static final int TCKIMLIKNO_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object tCKimlikNo_ = "";
  /**
   * <code>string TCKimlikNo = 1;</code>
   * @return The tCKimlikNo.
   */
  @java.lang.Override
  public java.lang.String getTCKimlikNo() {
    java.lang.Object ref = tCKimlikNo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      tCKimlikNo_ = s;
      return s;
    }
  }
  /**
   * <code>string TCKimlikNo = 1;</code>
   * @return The bytes for tCKimlikNo.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTCKimlikNoBytes() {
    java.lang.Object ref = tCKimlikNo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      tCKimlikNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AD_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object ad_ = "";
  /**
   * <code>string Ad = 2;</code>
   * @return The ad.
   */
  @java.lang.Override
  public java.lang.String getAd() {
    java.lang.Object ref = ad_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ad_ = s;
      return s;
    }
  }
  /**
   * <code>string Ad = 2;</code>
   * @return The bytes for ad.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAdBytes() {
    java.lang.Object ref = ad_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ad_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SOYAD_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object soyad_ = "";
  /**
   * <code>string Soyad = 3;</code>
   * @return The soyad.
   */
  @java.lang.Override
  public java.lang.String getSoyad() {
    java.lang.Object ref = soyad_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      soyad_ = s;
      return s;
    }
  }
  /**
   * <code>string Soyad = 3;</code>
   * @return The bytes for soyad.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSoyadBytes() {
    java.lang.Object ref = soyad_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      soyad_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DOGUMYILI_FIELD_NUMBER = 4;
  private int dogumYili_ = 0;
  /**
   * <code>int32 DogumYili = 4;</code>
   * @return The dogumYili.
   */
  @java.lang.Override
  public int getDogumYili() {
    return dogumYili_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(tCKimlikNo_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tCKimlikNo_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(ad_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ad_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(soyad_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, soyad_);
    }
    if (dogumYili_ != 0) {
      output.writeInt32(4, dogumYili_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(tCKimlikNo_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tCKimlikNo_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(ad_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ad_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(soyad_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, soyad_);
    }
    if (dogumYili_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, dogumYili_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)) {
      return super.equals(obj);
    }
    com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest other = (com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest) obj;

    if (!getTCKimlikNo()
        .equals(other.getTCKimlikNo())) return false;
    if (!getAd()
        .equals(other.getAd())) return false;
    if (!getSoyad()
        .equals(other.getSoyad())) return false;
    if (getDogumYili()
        != other.getDogumYili()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TCKIMLIKNO_FIELD_NUMBER;
    hash = (53 * hash) + getTCKimlikNo().hashCode();
    hash = (37 * hash) + AD_FIELD_NUMBER;
    hash = (53 * hash) + getAd().hashCode();
    hash = (37 * hash) + SOYAD_FIELD_NUMBER;
    hash = (53 * hash) + getSoyad().hashCode();
    hash = (37 * hash) + DOGUMYILI_FIELD_NUMBER;
    hash = (53 * hash) + getDogumYili();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)
      com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrula.internal_static_com_kurtlar_konseyi_freelancerclone_grpc_TcDogrulaRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrula.internal_static_com_kurtlar_konseyi_freelancerclone_grpc_TcDogrulaRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.class, com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.Builder.class);
    }

    // Construct using com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      tCKimlikNo_ = "";
      ad_ = "";
      soyad_ = "";
      dogumYili_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrula.internal_static_com_kurtlar_konseyi_freelancerclone_grpc_TcDogrulaRequest_descriptor;
    }

    @java.lang.Override
    public com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest getDefaultInstanceForType() {
      return com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest build() {
      com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest buildPartial() {
      com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest result = new com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.tCKimlikNo_ = tCKimlikNo_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.ad_ = ad_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.soyad_ = soyad_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.dogumYili_ = dogumYili_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest) {
        return mergeFrom((com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest other) {
      if (other == com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest.getDefaultInstance()) return this;
      if (!other.getTCKimlikNo().isEmpty()) {
        tCKimlikNo_ = other.tCKimlikNo_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getAd().isEmpty()) {
        ad_ = other.ad_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getSoyad().isEmpty()) {
        soyad_ = other.soyad_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getDogumYili() != 0) {
        setDogumYili(other.getDogumYili());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              tCKimlikNo_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              ad_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              soyad_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              dogumYili_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object tCKimlikNo_ = "";
    /**
     * <code>string TCKimlikNo = 1;</code>
     * @return The tCKimlikNo.
     */
    public java.lang.String getTCKimlikNo() {
      java.lang.Object ref = tCKimlikNo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tCKimlikNo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string TCKimlikNo = 1;</code>
     * @return The bytes for tCKimlikNo.
     */
    public com.google.protobuf.ByteString
        getTCKimlikNoBytes() {
      java.lang.Object ref = tCKimlikNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tCKimlikNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string TCKimlikNo = 1;</code>
     * @param value The tCKimlikNo to set.
     * @return This builder for chaining.
     */
    public Builder setTCKimlikNo(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      tCKimlikNo_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string TCKimlikNo = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTCKimlikNo() {
      tCKimlikNo_ = getDefaultInstance().getTCKimlikNo();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string TCKimlikNo = 1;</code>
     * @param value The bytes for tCKimlikNo to set.
     * @return This builder for chaining.
     */
    public Builder setTCKimlikNoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      tCKimlikNo_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object ad_ = "";
    /**
     * <code>string Ad = 2;</code>
     * @return The ad.
     */
    public java.lang.String getAd() {
      java.lang.Object ref = ad_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ad_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Ad = 2;</code>
     * @return The bytes for ad.
     */
    public com.google.protobuf.ByteString
        getAdBytes() {
      java.lang.Object ref = ad_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ad_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Ad = 2;</code>
     * @param value The ad to set.
     * @return This builder for chaining.
     */
    public Builder setAd(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ad_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string Ad = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAd() {
      ad_ = getDefaultInstance().getAd();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string Ad = 2;</code>
     * @param value The bytes for ad to set.
     * @return This builder for chaining.
     */
    public Builder setAdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ad_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object soyad_ = "";
    /**
     * <code>string Soyad = 3;</code>
     * @return The soyad.
     */
    public java.lang.String getSoyad() {
      java.lang.Object ref = soyad_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        soyad_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Soyad = 3;</code>
     * @return The bytes for soyad.
     */
    public com.google.protobuf.ByteString
        getSoyadBytes() {
      java.lang.Object ref = soyad_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        soyad_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Soyad = 3;</code>
     * @param value The soyad to set.
     * @return This builder for chaining.
     */
    public Builder setSoyad(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      soyad_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string Soyad = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSoyad() {
      soyad_ = getDefaultInstance().getSoyad();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string Soyad = 3;</code>
     * @param value The bytes for soyad to set.
     * @return This builder for chaining.
     */
    public Builder setSoyadBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      soyad_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private int dogumYili_ ;
    /**
     * <code>int32 DogumYili = 4;</code>
     * @return The dogumYili.
     */
    @java.lang.Override
    public int getDogumYili() {
      return dogumYili_;
    }
    /**
     * <code>int32 DogumYili = 4;</code>
     * @param value The dogumYili to set.
     * @return This builder for chaining.
     */
    public Builder setDogumYili(int value) {

      dogumYili_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 DogumYili = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearDogumYili() {
      bitField0_ = (bitField0_ & ~0x00000008);
      dogumYili_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)
  }

  // @@protoc_insertion_point(class_scope:com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest)
  private static final com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest();
  }

  public static com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TcDogrulaRequest>
      PARSER = new com.google.protobuf.AbstractParser<TcDogrulaRequest>() {
    @java.lang.Override
    public TcDogrulaRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<TcDogrulaRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TcDogrulaRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.kurtlar.konseyi.freelancerclone.grpc.TcDogrulaRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
