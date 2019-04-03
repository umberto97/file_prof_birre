package it.unicampania.lsadm.mybeers

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import it.unicampania.lsadm.mybeers.datamodel.Birra

/**
 * Adapter utilizzato per la RecyclerView con l'elenco delle birre
 *
 */
class BirreAdapter(val dataset: ArrayList<Birra>, val context: Context) : RecyclerView.Adapter<RigaBirraViewHolder>() {

    // Invocata per creare un ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RigaBirraViewHolder {
        // Crea e restituisce un viewholder, effettuando l'inflate del layout relativo alla riga
        return RigaBirraViewHolder(LayoutInflater.from(context).inflate(R.layout.riga_birra, viewGroup, false))
    }

    // Invocata per conoscere quanti elementi contiene il dataset
    override fun getItemCount(): Int {
        return dataset.size
    }

    // Invocata per visualizzare all'interno del ViewHolder il dato corrispondente alla riga
    override fun onBindViewHolder(viewHolder: RigaBirraViewHolder, position: Int) {
        val birra = dataset.get(position)

        viewHolder.tvNome.text = birra.nome
        viewHolder.tvProduttore.text = birra.produttore

        //imposto l'azione verso il fragment figlio sulla riga
        viewHolder.itemView.setOnClickListener {
            val b = Bundle() //è una bisaccia nella quale ci metto ciò che voglio trasportare

            b.putParcelable("birra", birra)
            Navigation.findNavController(it).navigate(R.id.action_birreFragment_to_figlio_fragment, b)
        }
    }
}