package it.unicampania.lsadm.mybeers.datamodel

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

/**
 * Classe per rappresentare una birra nella raccolta
 */
@Parcelize
data class Birra(var nome: String, var produttore: String, var tipologia: String, var gradazione: Float) : Parcelable