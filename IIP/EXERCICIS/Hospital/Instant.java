 

/**
 * <p>
 * Aquesta classe permet representar instants o marques de temps
 * (<code>Timestamp</code>) amb detall de minuts. Així, aquesta 
 * classe representa el moment o instant que defineix una hora,
 * en aquest cas, les hores i els minuts de la mateixa.
 * </p>
 * 
 *  @author IIP 
 *  @version Curs 2016-17
 */
public class Instant {

    // ATRIBUTS:
    /** Variable entera per emmagatzemar les hores. 
     *  Ha de pertanyer al rang <code>[0,23]</code>. */
    
    /** Variable entera per emmagatzemar els minuts. 
     *  Ha de pertanyer al rang <code>[0,59]</code>. */
    

    // CONSTRUCTORS:
    /**
     *  Crea un <code>Instant</code> amb el valor de
     *  les hores i els minuts que rep com arguments,
     *  <code>h</code> i <code>m</code> respectivament.
     *
     *  <p> Ha de complir-se la precondició: 
     *  <code>0 <= h < 24, 0 <= m < 60</code>. </p>
     */
    
   
    /**
     * Crea un <code>Instant</code> amb el valor de l'instant
     * actual UTC (temps universal coordinat).
     */
    
    
    // CONSULTORS I MODIFICADORS:
    /** Torna les <code>hores</code> de l'Instant. */
    

    /** Torna els <code>minuts</code> de l'Instant. */
    
   
    /** Actualitza les <code>hores</code> de l'Instant. */ 
    
   
    /** Actualitza els <code>minuts</code> de l'Instant. */ 
    
   
    // ALTRES MÈTODES:
    /** Torna l'Instant en el format "<code>hh:mm</code>". */
    
   
    /** Torna <code>true</code> sii <code>o</code> és 
     *  un objecte de la classe <code>Instant</code>
     *  i les seues <code>hores</code> i <code>minuts</code>
     *  coincideixen amb els de l'objecte en curs. 
     */
    
      
    /** Torna el número de minuts transcorreguts des de les 00:00 
     *  fins l'instant representat per l'objecte en curs.
     */
    
    
    /** Compara cronològicament l'instant de l'objecte en curs
     *  amb el de l'objecte de la classe <code>Instant</code> 
     *  referenciat per <code>altre</code>.
     *
     *  <p>
     *  El resultat és un valor:
     *  <ul>
     *     <li> negatiu si l'instant de l'objecte en curs 
     *     és anterior al de <code>altre</code>, </li>
     *     <li> zero si són iguals, </li>
     *     <li> positiu si l'Instant de l'objecte en curs 
     *     és posterior al de <code>altre</code>. </li>
     *  </ul>
     *  </p>
     */
    

    // ACTIVITAT EXTRA:
    /** Torna un <code>Instant</code> a partir de la descripció 
     *  textual (<code>String</code>) en format "<code>hh:mm</code>".
     */
    
}
