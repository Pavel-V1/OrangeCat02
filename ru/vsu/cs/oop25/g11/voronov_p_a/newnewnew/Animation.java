package ru.vsu.cs.oop25.g11.voronov_p_a.newnewnew;

import javax.swing.*;
import java.awt.*;

class ApplicationPanel extends JPanel {
    private float renderingTime = 0.0f;

    private float rectPositionX = 100;
    private float rectPositionY = 100;
    private float rectWidth = 200;
    private float rectHeight = 150;

    private float rectAnimationSpeed = 1000;
    private float rectAnimationDirectionX = 1.0f;
    private float rectAnimationDirectionY = 1.0f;

    private Color startColor = new Color(255, 111, 0);

    private Color finishColor = new Color(0, 0, 0);

    private Color currentColor = startColor;

    public ApplicationPanel() {
        setBackground(new Color(0, 0, 0));
    }

    public void update(float timeDelta) {
        renderingTime += timeDelta;

        rectPositionX += rectAnimationSpeed * rectAnimationDirectionX * timeDelta;
        rectPositionY += rectAnimationSpeed * rectAnimationDirectionY * timeDelta;

        if (rectPositionX < 0 || rectPositionX + rectWidth > getWidth()) {
            rectAnimationDirectionX *= -1;
        }

        if (rectPositionY < 0 || rectPositionY + rectHeight > getHeight()) {
            rectAnimationDirectionY *= -1;
        }

        float sinValue = (float) Math.sin(renderingTime * 5.0f); // [-1, 1]
        float sinValueRemapped = (sinValue + 1.0f) / 2.0f; // [0, 1]

        currentColor = new Color(
                (int) linearInterpolation(
                        startColor.getRed(), finishColor.getRed(), sinValueRemapped),
                (int) linearInterpolation(
                        startColor.getGreen(), finishColor.getGreen(), sinValueRemapped),
                (int) linearInterpolation(
                        startColor.getBlue(), finishColor.getBlue(), sinValueRemapped));
    }

    public float linearInterpolation(float min, float max, float time) {
        return min + (max - min) * time;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(currentColor);
        g.fillRect((int) rectPositionX,
                (int) rectPositionY,
                (int) rectWidth,
                (int) rectHeight);
    }
}

class ApplicationWindow extends JFrame {
    public ApplicationWindow() {
        setTitle("Task 1");
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(new Point(1920 / 2 - 640 / 2, 1080 / 2 - 480 / 2));

        ApplicationPanel panel = new ApplicationPanel();
        getContentPane().add(panel);

        pack();

        int applicationFPS = 30;

        Timer timer = new Timer(1000 / applicationFPS, event -> {
            panel.update(1.0f / applicationFPS);
            panel.repaint();
        });

        timer.start();
    }
}

public class Animation {
    public void animationPush() {
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.setVisible(true);
    }
}
