package com.example.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.composable.BoldText
import com.example.myapplication.composable.Icon
import com.example.myapplication.composable.NormalText

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TestScreen() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), shape = RoundedCornerShape(8.dp)
    ) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            val (pickupType, pickupId, area, status, vendorName, warehouse, documentationIcon, locationIcon, callIcon, emailIcon) = createRefs()
            BoldText(text = "Stock Pickup",
                textColor = Color.Black,
                modifier = Modifier.constrainAs(pickupType) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
            NormalText(text = "SP13", modifier = Modifier.constrainAs(pickupId) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })

            NormalText(text = "Vendor Name: idea egypt",
                modifier = Modifier.constrainAs(vendorName) {
                    top.linkTo(pickupType.bottom)
                    start.linkTo(parent.start)
                })

            NormalText(text = "Area:Naser City, Cairo, Egypt",
                modifier = Modifier.constrainAs(area) {
                    top.linkTo(vendorName.bottom)
                    start.linkTo(parent.start)
                })

            NormalText(text = "Status: Assigned For pickup",
                modifier = Modifier.constrainAs(status) {
                    start.linkTo(area.end, 16.dp)
                    top.linkTo(vendorName.bottom)
                })

            NormalText(text = "Deliver to Warehouse: الاسماعيلية",
                modifier = Modifier.constrainAs(warehouse) {
                    bottom.linkTo(emailIcon.bottom)
                    start.linkTo(parent.start)
                })

            Icon(painter = painterResource(id = R.drawable.baseline_email_24),
                iconTint = Color.White,
                modifier = Modifier
                    .background(color = Color.Red)
                    .padding(3.dp)
                    .constrainAs(emailIcon) {
                        top.linkTo(area.bottom, 8.dp)
                        end.linkTo(parent.end)
                    })

            Icon(painter = painterResource(id = R.drawable.baseline_location_on_24),
                iconTint = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(3.dp)
                    .constrainAs(locationIcon) {
                        end.linkTo(emailIcon.start, 8.dp)
                        bottom.linkTo(emailIcon.bottom)
                    })

            Icon(painter = painterResource(id = R.drawable.baseline_call_24),
                iconTint = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(2.dp)
                    .constrainAs(callIcon) {
                        end.linkTo(locationIcon.start, 8.dp)
                        bottom.linkTo(emailIcon.bottom)
                    })

            Icon(painter = painterResource(id = R.drawable.baseline_document_scanner_24),
                iconTint = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(2.dp)
                    .constrainAs(documentationIcon) {
                        end.linkTo(callIcon.start, 8.dp)
                        bottom.linkTo(emailIcon.bottom)
                    })

            val horizontalGuideline = createGuidelineFromTop(300.dp)
            val verticalGuideline = createGuidelineFromStart(0.80f)

            val (mama,dad,family) = createRefs()
            val horizontalChain=createHorizontalChain(mama,dad,family, chainStyle = ChainStyle.SpreadInside)
            BoldText(text = "Mama ",
                textColor = Color.Black,
                modifier = Modifier.constrainAs(mama) {
                    top.linkTo(horizontalGuideline)
                })

            BoldText(text = "Dad",
                textColor = Color.Black,
                modifier = Modifier.constrainAs(dad) {
                    top.linkTo(horizontalGuideline)
                })

            BoldText(text = "Family",
                textColor = Color.Black,
                modifier = Modifier.constrainAs(family) {
                    top.linkTo(horizontalGuideline)
                })


        }

    }
}
  
