package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptographyActivity extends AppCompatActivity {

    private EditText textInput;
    private EditText passwordInput;
    private TextView encryptionText;
    private TextView decryptionText;
    private Button encryptButton;
    private Button decryptButton;
    private String outputString;
    private final String AES = "AES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptography);

        textInput = findViewById(R.id.text_input);
        passwordInput = findViewById(R.id.password_input);
        encryptionText = findViewById(R.id.text_encrypt);
        decryptionText = findViewById(R.id.text_decrypt);
        encryptButton = findViewById(R.id.encryption_button);
        decryptButton = findViewById(R.id.decryption_button);


        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    outputString = encryptText(textInput.getText().toString(), passwordInput.getText().toString());
                    encryptionText.setText(outputString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                outputString = decryptText();
            }
        });



    }

    private String encryptText(String text, String password) throws Exception {
        SecretKeySpec key = generateKey(password);
        Cipher c = Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValueArray = c.doFinal(text.getBytes());
        String encValue = Base64.getEncoder().encodeToString(encValueArray);
        return encValue;
    }

    private SecretKeySpec generateKey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        return new SecretKeySpec(key, AES);
    }
}
