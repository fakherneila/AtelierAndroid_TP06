# AtelierAndroid_TP06

Application Android Kotlin réalisée dans le cadre du **TP06 de Développement Mobile**, portant sur le cycle de vie des activités, la structure du manifeste Android et l’utilisation des fonctions de portée Kotlin.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.x-purple?logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-SDK%2034-green?logo=android)](https://developer.android.com/)
[![Gradle](https://img.shields.io/badge/Gradle-8.5-blue?logo=gradle)](https://gradle.org/)
[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://www.oracle.com/java/)

##  Table des matières

- [AtelierAndroid\_TP06](#atelierandroid_tp06)
  - [Table des matières](#table-des-matières)
  - [Fonctionnalités](#fonctionnalités)
    - [Formulaire d'inscription](#formulaire-dinscription)
    - [Activité et Manifest](#activité-et-manifest)
    - [Cycle de vie](#cycle-de-vie)
    - [Fonctions de portée Kotlin](#fonctions-de-portée-kotlin)
  - [Technologies utilisées](#technologies-utilisées)
  - [Structure du projet](#structure-du-projet)
    - [Fichiers principaux](#fichiers-principaux)
  - [Prérequis](#prérequis)
    - [Java 21](#java-21)
    - [Android SDK](#android-sdk)
    - [`local.properties`](#localproperties)
  - [Compilation et installation](#compilation-et-installation)
    - [1. Rendre Gradle Wrapper exécutable](#1-rendre-gradle-wrapper-exécutable)
    - [2. Compiler l’application](#2-compiler-lapplication)
    - [3. Installer avec ADB](#3-installer-avec-adb)
    - [4. Lancer l’application](#4-lancer-lapplication)
  - [Observer le cycle de vie](#observer-le-cycle-de-vie)
    - [Actions et callbacks attendus](#actions-et-callbacks-attendus)
  - [Fonctions de portée Kotlin](#fonctions-de-portée-kotlin-1)
    - [`let`](#let)
    - [`run`](#run)
    - [`apply`](#apply)
    - [`with`](#with)
    - [`also`](#also)
  - [Scénarios de test](#scénarios-de-test)
  - [Dépannage](#dépannage)
  - [Auteur](#auteur)
    - [GitHub](#github)

##  Fonctionnalités

### Formulaire d'inscription

Les fonctionnalités développées dans le TP05 sont conservées :

- Saisie du **nom** et du **prénom**.
- Saisie de l’**âge**.
- Sélection du groupe parmi **G1, G2 et G3**.
- Sélection du support de test via **RadioButton**.
- Confirmation via **CheckBox**.
- Enregistrement d’un participant.
- Affichage de la liste des participants.
- Recherche d’un participant.
- Modification d’un participant.
- Suppression d’un participant.
- Filtrage des participants par groupe.
- Conservation de l’état lors d’une rotation de l’écran grâce à un `Bundle`.
- Sauvegarde des participants et du filtre actif lors de la recréation de l’activité.

### Activité et Manifest

Le TP06 introduit une deuxième activité dédiée aux informations techniques :

- Création de `FicheTechniqueActivity`.
- Déclaration de l’activité dans `AndroidManifest.xml`.
- Utilisation de `android:exported="false"`.
- Aucun `intent-filter` pour `FicheTechniqueActivity`.
- Affichage d’un message explicatif statique dans la deuxième activité.

### Cycle de vie

Le cycle de vie de `MainActivity` est observé grâce à Logcat.

Les callbacks suivants sont journalisés :

- `onCreate()`
- `onStart()`
- `onResume()`
- `onPause()`
- `onStop()`
- `onRestart()`
- `onDestroy()`

Les messages utilisent le tag :

```text
AtelierCycle
```

### Fonctions de portée Kotlin

Le TP06 utilise les cinq fonctions de portée Kotlin :

- `let`
- `run`
- `with`
- `apply`
- `also`

Elles sont utilisées dans `AnalyseScope.kt` pour analyser le participant sélectionné.

Un bouton rose **« Analyser »** (`btnAnalyserTP06`) lance l’analyse et affiche le résultat formaté dans `tvResultat`.

##  Technologies utilisées

| Technologie | Version / Configuration | Utilisation |
|---|---|---|
| Kotlin | 1.x | Langage principal |
| Android SDK | 34 | SDK cible |
| Min SDK | 24 | Version Android minimale |
| Gradle | 8.5 | Système de build |
| Android Gradle Plugin | 8.2.2 | Plugin Android |
| Java / JDK | 21 | Compilation et exécution |
| IDE | VS Code | Environnement de développement |
| ADB | Android SDK Platform Tools | Installation et exécution |

##  Structure du projet

```text
AtelierAndroid_TP06/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── .../
│           │       ├── MainActivity.kt
│           │       ├── FicheTechniqueActivity.kt
│           │       ├── AnalyseScope.kt
│           │       └── Participant.kt
│           │
│           ├── res/
│           │   ├── layout/
│           │   ├── values/
│           │   │   └── strings.xml
│           │   └── ...
│           │
│           └── AndroidManifest.xml
│
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
│
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── local.properties
```

### Fichiers principaux

- **`MainActivity.kt`** : activité principale, formulaire, liste, recherche, modification, suppression, filtrage et cycle de vie.
- **`FicheTechniqueActivity.kt`** : deuxième activité affichant les informations techniques du TP06.
- **`AnalyseScope.kt`** : implémentation des cinq fonctions de portée Kotlin.
- **`Participant.kt`** : modèle représentant un participant.
- **`AndroidManifest.xml`** : déclaration et configuration des activités.

##  Prérequis

### Java 21

```bash
java -version
```

Le projet nécessite **JDK 21**.

### Android SDK

Installer au minimum :

- Android SDK Platform 34
- Android SDK Build-Tools
- Android SDK Platform-Tools

Vérifier ADB :

```bash
adb version
```

### `local.properties`

Le fichier `local.properties` doit pointer vers le SDK Android installé localement.

Exemple :

```properties
sdk.dir=/home/<username>/Android/Sdk
```

> `local.properties` est spécifique à la machine et ne doit normalement pas être versionné dans Git.

##  Compilation et installation

### 1. Rendre Gradle Wrapper exécutable

Sous Linux/macOS :

```bash
chmod +x gradlew
```

### 2. Compiler l’application

```bash
./gradlew assembleDebug
```

L’APK est généré dans :

```text
app/build/outputs/apk/debug/app-debug.apk
```

### 3. Installer avec ADB

Vérifier qu’un appareil ou un émulateur est connecté :

```bash
adb devices
```

Puis installer l’APK :

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### 4. Lancer l’application

```bash
adb shell am start -n <package_name>/.MainActivity
```

Remplacer `<package_name>` par le package réel de l’application.

##  Observer le cycle de vie

Les callbacks peuvent être observés dans **Logcat** en filtrant avec le tag :

```text
AtelierCycle
```

Avec ADB :

```bash
adb logcat -s AtelierCycle
```

### Actions et callbacks attendus

| Action | Callbacks attendus |
|---|---|
| **Lancer l’application** | `onCreate()` → `onStart()` → `onResume()` |
| **Appuyer sur Home** | `onPause()` → `onStop()` |
| **Revenir dans l’application** | `onRestart()` → `onStart()` → `onResume()` |
| **Tourner l’écran** | `onPause()` → `onStop()` → `onDestroy()` → `onCreate()` → `onStart()` → `onResume()` |
| **Appuyer sur Retour** | `onPause()` → `onStop()` → `onDestroy()` |

> L’ordre peut légèrement varier selon la version Android et la configuration de l’appareil.

##  Fonctions de portée Kotlin

### `let`

`let` est utilisée pour gérer de manière sûre le participant sélectionné, qui peut être `null`.

```kotlin
participantSelectionne?.let {
    // Analyse du participant
}
```

### `run`

`run` permet d’exécuter un bloc dans le contexte d’un objet et de retourner un résultat. Dans ce projet, elle permet de déterminer si le participant est majeur :

```kotlin
val estMajeur = participant.run {
    age >= 18
}
```

Le résultat est un `Boolean`.

### `apply`

`apply` permet de configurer un objet et retourne le même objet. Elle est utilisée pour construire un `BilanParticipant` :

```kotlin
val bilan = BilanParticipant().apply {
    // Configuration du bilan
}
```

### `with`

`with` permet d’exécuter plusieurs opérations dans le contexte d’un objet. Elle est utilisée ici pour construire le nom complet :

```kotlin
val nomComplet = with(participant) {
    "$prenom $nom"
}
```

### `also`

`also` permet d’effectuer une action secondaire tout en retournant l’objet original. Dans ce projet, elle sert notamment à tracer le résultat avec la lambda `trace` :

```kotlin
bilan.also {
    trace("Bilan : $it")
}
```

##  Scénarios de test

| ID | Action | Résultat attendu |
|---|---|---|
| **T01** | Saisir le nom, prénom, âge et groupe | Les données sont correctement saisies |
| **T02** | Sélectionner le support de test et confirmer | Les contrôles sont correctement pris en compte |
| **T03** | Enregistrer un participant valide | Le participant est ajouté à la liste |
| **T04** | Consulter la liste | Les participants enregistrés sont affichés |
| **T05** | Rechercher un participant | Les résultats correspondants sont affichés |
| **T06** | Modifier un participant | Les informations modifiées sont enregistrées |
| **T07** | Supprimer un participant | Le participant est supprimé de la liste |
| **T08** | Filtrer par G1, G2 ou G3 | Seuls les participants du groupe choisi sont affichés |
| **T09** | Faire pivoter l’écran | Les participants et le filtre actif sont conservés |
| **T10** | Ouvrir `FicheTechniqueActivity` | La deuxième activité affiche son message explicatif |
| **T11** | Effectuer des actions sur l’activité et consulter Logcat | Les callbacks apparaissent avec le tag `AtelierCycle` |
| **T12** | Sélectionner un participant puis cliquer sur **Analyser** | Le bilan est généré avec `let`, `run`, `apply`, `with` et `also`, puis affiché dans `tvResultat` |

##  Dépannage

| Symptôme | Cause | Solution |
|---|---|---|
| `./gradlew` ne fonctionne pas | Le wrapper n’est pas exécutable | Exécuter `chmod +x gradlew` |
| `gradle-wrapper.jar` manquant | Le fichier du Gradle Wrapper est absent ou incomplet | Vérifier `gradle/wrapper/gradle-wrapper.jar` et restaurer le fichier depuis le repository |
| `Invalid unicode escape sequence` dans `strings.xml` | Un `\` est interprété comme une séquence Unicode invalide | Vérifier les chaînes contenant `\` et utiliser `\\` pour représenter un backslash littéral |
| Erreur liée à Java 11 | Le projet utilise une version Java trop ancienne | Installer et utiliser **JDK 21** |
| `Unsupported class file major version` | Version Java incompatible | Vérifier que Gradle utilise JDK 21 |
| `SDK location not found` | Android SDK non configuré | Vérifier `local.properties` et `sdk.dir` |
| Aucun appareil détecté par ADB | Appareil non connecté ou débogage USB désactivé | Exécuter `adb devices` et activer le débogage USB ou démarrer un émulateur |
| L’application ne s’installe pas | APK ou ancienne installation problématique | Utiliser `adb install -r app-debug.apk` et vérifier le `minSdk` |
| Les logs `AtelierCycle` n’apparaissent pas | Filtre Logcat incorrect | Utiliser `adb logcat -s AtelierCycle` |
| L’état est perdu après rotation | Données non sauvegardées dans le `Bundle` | Vérifier la sauvegarde/restauration des participants et du filtre actif |

##  Auteur

**Fakher Neila**  
Classe : **ING-A3-GL-AL-04**  
Module : **Développement Mobile — TP06**

### GitHub

[https://github.com/fakherneila/AtelierAndroid_TP06](https://github.com/fakherneila/AtelierAndroid_TP06)
