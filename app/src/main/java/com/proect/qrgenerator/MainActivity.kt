package com.proect.qrgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {
    var im: ImageView? = null
    var bGenerate: Button? = null
    var bScanner: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        im = findViewById(R.id.imageView)
        bGenerate = findViewById(R.id.button)
        bScanner = findViewById(R.id.bScan)
        bScanner?.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
        }
        bGenerate?.setOnClickListener {
            generateQrCode("QR код сгенерирован")
        }
    }

    private fun generateQrCode(text: String){
        val qrGeneretor = QRGEncoder(text, null, QRGContents.Type.TEXT, 500)
        try {

            val bMap = qrGeneretor.encodeAsBitmap()
            im?.setImageBitmap(bMap)
        } catch (e: WriterException){

        }
    }
}