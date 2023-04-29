package com.dukcapil.ikd_sso.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profil {
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("tgl_lahir")
    @Expose
    private String tglLahir;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("kk")
    @Expose
    private String kk;
    @SerializedName("rt")
    @Expose
    private String rt;
    @SerializedName("rw")
    @Expose
    private String rw;
    @SerializedName("kelurahan")
    @Expose
    private String kelurahan;
    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;
    @SerializedName("kabupaten")
    @Expose
    private String kabupaten;
    @SerializedName("provinsi")
    @Expose
    private String provinsi;
    @SerializedName("kode_pos")
    @Expose
    private String kode_pos;
    @SerializedName("golongan_darah")
    @Expose
    private String golongan_darah;
    @SerializedName("status_pernikahan")
    @Expose
    private String status_pernikahan;
    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenis_kelamin;
    @SerializedName("hub_keluarga")
    @Expose
    private String hub_keluarga;
    @SerializedName("nama_ibu")
    @Expose
    private String nama_ibu;
    @SerializedName("nik_ibu")
    @Expose
    private String nik_ibu;
    @SerializedName("nama_ayah")
    @Expose
    private String nama_ayah;
    @SerializedName("nik_ayah")
    @Expose
    private String nik_ayah;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }

    public String getGolongan_darah() {
        return golongan_darah;
    }

    public void setGolongan_darah(String golongan_darah) {
        this.golongan_darah = golongan_darah;
    }

    public String getStatus_pernikahan() {
        return status_pernikahan;
    }

    public void setStatus_pernikahan(String status_pernikahan) {
        this.status_pernikahan = status_pernikahan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getHub_keluarga() {
        return hub_keluarga;
    }

    public void setHub_keluarga(String hub_keluarga) {
        this.hub_keluarga = hub_keluarga;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getNik_ibu() {
        return nik_ibu;
    }

    public void setNik_ibu(String nik_ibu) {
        this.nik_ibu = nik_ibu;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getNik_ayah() {
        return nik_ayah;
    }

    public void setNik_ayah(String nik_ayah) {
        this.nik_ayah = nik_ayah;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
}
