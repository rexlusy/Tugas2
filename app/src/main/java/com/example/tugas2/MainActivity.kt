package com.example.tugas2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Biru = Color(0xFF2563EB)
private val TeksUtama = Color(0xFF1F2937)
private val TeksSekunder = Color(0xFF64748B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                HalamanProfil()
            }
        }
    }
}

@Composable
fun HalamanProfil() {
    // COLUMN: menyusun isi halaman dari atas ke bawah.
    // MODIFIER: mengatur ukuran, warna, area aman, scroll, dan jarak.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F5F9))
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profil Saya",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = TeksUtama
        )

        // SPACER: memberi jarak antarbagian.
        Spacer(modifier = Modifier.height(20.dp))

        // BOX: menempatkan ikon di tengah latar berbentuk lingkaran.
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .background(Color(0xFFDBEAFE)),
            contentAlignment = Alignment.Center
        ) {
            // ICON: menampilkan gambar dari objek Icons.
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Avatar profil",
                modifier = Modifier.size(64.dp),
                tint = Biru
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // TEXT: menampilkan nama dan status mahasiswa.
        Text(
            text = "Muhammad Rifa Aqilla",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = TeksUtama,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Mahasiswa Sistem Informasi\n Universitas Brawijaya",
            fontSize = 14.sp,
            color = TeksSekunder,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Data Diri",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TeksUtama
            )

            BarisInformasi(
                Icons.Default.Person,
                "NIM",
                "245150407111047"
            )

            BarisInformasi(
                Icons.Default.Home,
                "Alamat",
                "Malang"
            )

            BarisInformasi(
                Icons.Default.Email,
                "Email",
                "rifaaqla1512@student.ub.ac.id"
            )

            BarisInformasi(
                Icons.Default.Phone,
                "Nomor HP",
                "0821-2540-5353"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Tentang Saya",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TeksUtama
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Saya mahasiswa Sistem Informasi yang sedang belajar " +
                        "membuat aplikasi Android menggunakan Jetpack Compose.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = TeksSekunder
            )
        }
    }
}

@Composable
fun BarisInformasi(ikon: ImageVector, label: String, isi: String) {
    // ROW: menyusun ikon dan teks secara horizontal.
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ikon,
            contentDescription = null, // Informasi sudah dijelaskan oleh teks.
            modifier = Modifier.size(24.dp),
            tint = Biru
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = TeksSekunder
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = isi,
                fontSize = 15.sp,
                color = TeksUtama
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewHalamanProfil() {
    MaterialTheme {
        HalamanProfil()
    }
}