/*
 * Copyright (c) September 2017 FTC Teams 25/5218
 *
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification,
 *  are permitted (subject to the limitations in the disclaimer below) provided that
 *  the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this list
 *  of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice, this
 *  list of conditions and the following disclaimer in the documentation and/or
 *  other materials provided with the distribution.
 *
 *  Neither the name of FTC Teams 25/5218 nor the names of their contributors may be used to
 *  endorse or promote products derived from this software without specific prior
 *  written permission.
 *
 *  NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 *  LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  AS IS AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 *  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 *  FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 *  DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *  CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 *  TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package team25core;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

public class MRLightSensor implements LightSensor {

    OpticalDistanceSensor ods;

    public MRLightSensor(OpticalDistanceSensor opticalDistanceSensor)
    {
       ods = opticalDistanceSensor;
    }
    @Override
    public double getLightDetected()
    {
        return ods.getLightDetected();
    }

    @Override
    public double getRawLightDetected()
    {
        return ods.getRawLightDetected();
    }

    @Override
    public double getRawLightDetectedMax()
    {
        return ods.getRawLightDetectedMax();
    }

    @Override
    public void enableLed(boolean enable)
    {
        ods.enableLed(enable);
    }

    @Override
    public String status()
    {
        return ods.status();
    }

    @Override
    public Manufacturer getManufacturer()
    {
        return ods.getManufacturer();
    }

    @Override
    public String getDeviceName()
    {
        return ods.getDeviceName();
    }

    @Override
    public String getConnectionInfo()
    {
        return ods.getConnectionInfo();
    }

    @Override
    public int getVersion()
    {
        return ods.getVersion();
    }

    @Override
    public void resetDeviceConfigurationForOpMode()
    {
        ods.resetDeviceConfigurationForOpMode();
    }

    @Override
    public void close()
    {
        ods.close();
    }
}
