// Defining the package for app's functionality
package com.kodeco.chat

// Importing necessary Android and Jetpack Compose components for building the chat UI
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//MainActivity is the entry point of the app which sets up the user interface for the application.
//This app displays an input field for the user to type a message, and a button to send the message.
// When the button is clicked, the message is displayed below the input field.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Creating a column layout for arranging elements vertically
            Column {
                // Defining mutable state for chat input text and output text
                // CHANGE: changed default text in input field
                var chatInputText by remember { mutableStateOf("Enter your message here.") }

                // CHANGE: changed default output text
                var chatOutputText by remember { mutableStateOf("Your message will appear here after sending.") }

                // Displaying the output text
                Text(text = chatOutputText)

                // Displaying input field (outilned text field) for the user to type a message
                OutlinedTextField(
                    value = chatInputText,
                    onValueChange = {
                        // Updating the input text when user types
                        chatInputText = it
                    },
                    // CHANGE: updated label to provide more clarity on input purpose
                    label = { Text("Your message") } // Label for the input field
                )

                // Button to send the message
                Button(onClick = {
                    // Updating the output text with the input text when the button is pressed
                    chatOutputText = chatInputText
                    // Clearing the input text field after sending the message
                    chatInputText = ""
                }) {
                    // CHANGE: changed button text to "Send Message" for better clarity
                    Text(text = "Send Message") // Updated button text to be more descriptive
                }
            }
        }
    }
}
