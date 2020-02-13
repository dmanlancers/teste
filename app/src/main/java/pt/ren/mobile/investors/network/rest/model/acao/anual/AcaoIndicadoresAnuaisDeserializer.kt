package pt.ren.mobile.investors.network.rest.model.acao.anual

import android.icu.util.Calendar
import android.util.Log
import com.google.gson.*
import java.lang.reflect.Type


class AcaoIndicadoresAnuaisDeserializer :
    JsonDeserializer<AcaoIndicadoresAnuaisList?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): AcaoIndicadoresAnuaisList {
        var indicadores: AcaoIndicadoresAnuaisList //Resultado final
        var indicador: AcaoIndicadoresAnuais //objecto que guarda o resultado da iteração atual
        val arrayIndicadores: ArrayList<AcaoIndicadoresAnuais> = ArrayList()
        val gson = Gson()
        var values: MutableList<AcaoIndicadoresAnuaisValues?> =
            ArrayList()
        val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)
        val jsonObject = json.asJsonObject
        val content = jsonObject.getAsJsonArray("content")
        val cenas2 = content[0].asJsonObject
        //final JsonObject cenas = cenas2.getAsJsonObject("TabelaIndicadores_Anuais_RE");
        try {
            for (j in content) {
                val iter =
                    j.asJsonObject.getAsJsonObject("TabelaIndicadores_Anuais_Acao")
                val keys = iter.keySet()
                for (i in 0..6) {
                    val valueToAdd = AcaoIndicadoresAnuaisValues()
                    val iterationYear = currentYear - i
                    valueToAdd.year = "" + iterationYear
                    for (s in keys) { //Log.d("KEYS", s);
                        if (s.contains("" + iterationYear) && s.startsWith("pt")) {
                            val testing = gson.fromJson(
                                iter[s],
                                String::class.java
                            )
                            valueToAdd.ptValue =
                                gson.fromJson(iter[s], String::class.java)
                            Log.d("JSON", valueToAdd.ptValue)
                            continue
                        }
                        if (s.contains("" + iterationYear) && s.startsWith("en")) {
                            valueToAdd.enValue =
                                gson.fromJson(iter[s], String::class.java)
                            Log.d("JSON", valueToAdd.enValue)
                            continue
                        }
                    }
                    values.add(valueToAdd)
                }
                indicador = AcaoIndicadoresAnuais(
                    gson.fromJson(
                        iter["pt_pt__Separator"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["pt_pt__share"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["pt_pt__unit"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["en_gb__Separator"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["en_gb__share"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["en_gb__unit"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["dte_init"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["dte_end"],
                        String::class.java
                    ),
                    gson.fromJson(iter["dte_state"], String::class.java),
                    gson.fromJson(
                        iter["scrId"],
                        String::class.java
                    ),
                    gson.fromJson(
                        iter["srcLang"],
                        String::class.java
                    ),
                    gson.fromJson(iter["srcChannel"], String::class.java),
                    gson.fromJson(
                        iter["srcState"],
                        String::class.java
                    ),
                    values
                )
                arrayIndicadores.add(indicador)
                values = ArrayList()
            }
            indicadores = AcaoIndicadoresAnuaisList("", "", arrayIndicadores)
        } catch (e: Exception) { //TODO: properly handle the exception
            indicadores = AcaoIndicadoresAnuaisList("", "", ArrayList<AcaoIndicadoresAnuais>())
            /*indicadores = new  REIndicadoresAnuais(gson.fromJson(iter.get("pt_pt__Separator"), String.class), gson.fromJson(iter.get("pt_pt__exploration_results"), String.class), gson.fromJson(iter.get("pt_pt__unit"), String.class),
                    gson.fromJson(iter.get("en_gb__Separator"), String.class), gson.fromJson(iter.get("en_gb__exploration_results"), String.class), gson.fromJson(iter.get("en_gb__unit"), String.class),  gson.fromJson(iter.get("dte_init"), String.class), gson.fromJson(iter.get("dte_end"), String.class),
                    gson.fromJson(iter.get("dte_state"), String.class), gson.fromJson(iter.get("scrId"), String.class), gson.fromJson(iter.get("srcLang"), String.class),
                    gson.fromJson(iter.get("srcChannel"), String.class), gson.fromJson(iter.get("srcState"), String.class), values );
*/
        }
        return indicadores
    }
}