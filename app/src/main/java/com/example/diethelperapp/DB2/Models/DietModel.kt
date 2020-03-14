package com.example.diethelperapp.DB2.Models

interface DietModel {
    var dietId: Int
    var dietName: String?
    var supportingInformation: String?
    var duration: Int
}