package com.example.myar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class Sofa extends AppCompatActivity {

    private ArFragment arFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa);
        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arfragment);

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            Anchor anchor =hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(Sofa.this, Uri.parse("Sofa_01.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable))
                    .exceptionally(throwable -> {
                        AlertDialog.Builder builder=new AlertDialog.Builder(Sofa.this);

                        builder.setMessage(throwable.getMessage()).show();
                        return null;
                    });

        });
    }
    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
        AnchorNode anchorNode=new AnchorNode(anchor);
        TransformableNode transformableNode=new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();

    }

    public void buynow(View view) {
        Intent intent = new Intent(Sofa.this,sofaweb.class);
        startActivity(intent);

    }
}