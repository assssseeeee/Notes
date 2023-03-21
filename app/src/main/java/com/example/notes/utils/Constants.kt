package com.example.notes.utils

import com.example.notes.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository


object Constants {
    object Keys {
        const val UPDATE_NOTE = "UPDATE NOTE"
        const val NAV_BACK = "NAV_BACK"
        const val NOTES_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "add new note"
        const val NOTE_TITLE = "note title"
        const val NOTE_SUBTITLE = "note subtitle"
        const val ADD_NOTE = "add note"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val ID = "id"
        const val NONE = "none"
        const val UPDATE = "UPDATE"
        const val DELETE = "DELETE"
        const val EDIT_NOTE = "EDIT NOTE"
        const val EMPTY = "empty"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val NOTE_SCREEN = "note_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
    }
}