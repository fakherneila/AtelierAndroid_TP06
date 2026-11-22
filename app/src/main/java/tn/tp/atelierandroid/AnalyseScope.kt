package tn.tp.atelierandroid

// Data class demandée
data class BilanParticipant(
    var identite: String = "",
    var age: Int = 0,
    var groupe: String = "",
    var support: String = "",
    var majeur: Boolean = false
)

object AnalyseScope {

    fun preparer(participant: Participant?, trace: (String) -> Unit = {}): BilanParticipant? {
        // Q5: let protège contre le null. Si participant == null, retourne null.
        return participant?.let { p ->
            // Q6: run exécute un bloc et retourne le résultat (ici un Boolean)
            val estMajeur = p.run { age >= 18 }

            // apply configure l'objet et retourne l'objet lui-même
            BilanParticipant().apply {
                // Q7: with permet d'accéder aux propriétés de 'p' sans répéter 'p.'
                identite = with(p) { "$prenom $nom" }
                age = p.age
                groupe = p.groupe
                support = p.support
                majeur = estMajeur
            }.also { bilan ->
                // also exécute un effet de bord (trace) et retourne l'objet intact
                trace("TP06 bilan : ${bilan.identite} - Majeur: ${bilan.majeur}")
            }
        }
    }
}