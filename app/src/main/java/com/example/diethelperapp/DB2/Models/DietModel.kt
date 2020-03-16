package com.example.diethelperapp.db2.models

interface DietModel {
    var dietId: Int
    var dietName: String?
    var supportingInformation: String?
    var duration: Int
}