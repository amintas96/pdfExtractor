package org.example;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
public class Main {
        /**
         * Le o conteudo (texto) de um arquivo pdf
         */
        public static String extraiTextoDoPDF (String caminho) {
            PDDocument pdfDocument = null;
            try {
                pdfDocument = PDDocument.load(new File(caminho));
                PDFTextStripper stripper = new PDFTextStripper();
                String texto = stripper.getText(pdfDocument);
                return texto;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (pdfDocument != null) try {
                    pdfDocument.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /**
         * Extrai o conteudo do arquivo indicado
         */
        public static void main(String[] args) {
            String caminho= "/home/amintas/Downloads/relatorio.pdf";
            String texto = extraiTextoDoPDF(caminho);
            System.out.println(texto);
        }
    }





