package com.example.prashant_admin.raspnotifier;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by prashant-admin on 20/12/17.
 */

public class TemperatureDataAdapter extends RecyclerView.Adapter<TemperatureDataViewHolder>{

    private static final String IV_STRING = "";
    private static final String charset = "UTF-8";
    private List<TemperatureData> temperatureDataList;
    protected Context context;
    public TemperatureDataAdapter(Context context, List<TemperatureData> temperatureDataList) {
        this.temperatureDataList = temperatureDataList;
        this.context = context;
    }
    @Override
    public TemperatureDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TemperatureDataViewHolder viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        viewHolder = new TemperatureDataViewHolder(layoutView, temperatureDataList);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(TemperatureDataViewHolder holder, int position) {
        String key = temperatureDataList.get(position).getKey();
        String tempData = temperatureDataList.get(position).getTemperature();
        String decryptedTemp = "";
        try {
           decryptedTemp = aesDecryptString(tempData,key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String finalTemp = decryptedTemp +" \u2103";
        holder.temperatureTextView.setText(finalTemp);
        holder.messageTextView.setText(temperatureDataList.get(position).getMessage());
        holder.dateTextView.setText(temperatureDataList.get(position).getDate());
    }
    @Override
    public int getItemCount() {
        return this.temperatureDataList.size();
    }

    public static String aesEncryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] contentBytes = content.getBytes(charset);
        byte[] keyBytes = key.getBytes(charset);
        String s = "";
        byte[] encryptedBytes = aesEncryptBytes(contentBytes, keyBytes);
        Base64.Encoder encoder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encoder = Base64.getEncoder();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            s = encoder.encodeToString(encryptedBytes);
            return encoder.encodeToString(encryptedBytes);
        }
        return s;
    }

    public static String aesDecryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Base64.Decoder decoder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            decoder = Base64.getDecoder();
        }
        byte[] encryptedBytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encryptedBytes = decoder.decode(content);
        }
        byte[] keyBytes = key.getBytes(charset);
        byte[] decryptedBytes = aesDecryptBytes(encryptedBytes, keyBytes);
        return new String(decryptedBytes, charset);
    }
    public static byte[] aesEncryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(contentBytes, keyBytes, Cipher.ENCRYPT_MODE);
    }

    public static byte[] aesDecryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(contentBytes, keyBytes, Cipher.DECRYPT_MODE);
    }
    private static byte[] cipherOperation(byte[] contentBytes, byte[] keyBytes, int mode) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        byte[] initParam = IV_STRING.getBytes(charset);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(mode, secretKey, ivParameterSpec);

        return cipher.doFinal(contentBytes);
    }
}

