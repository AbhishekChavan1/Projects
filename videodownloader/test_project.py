from project import valid, available_reso
import pytest

def test_valid():
    assert valid("https://www.youtube.com/shorts/EHWqOUzFSxU") == "https://www.youtube.com/shorts/EHWqOUzFSxU"
    assert valid("https://www.youtube.com/zWh3CShX_do?si=fwNkdoKfvojTRbs-") == "https://www.youtube.com/zWh3CShX_do?si=fwNkdoKfvojTRbs-"
    assert valid("www.youtube.com/shorts/ufNgIeS3rg8") == "www.youtube.com/shorts/ufNgIeS3rg8"

def test_function_2():
    assert ("http://www.youtube.com/shorts/ufNgIeS3rg8")

def test_available_reso():
    assert available_reso('<Stream: itag="17" mime_type="video/3gpp" res="144p" fps="8fps" vcodec="mp4v.20.3" acodec="mp4a.40.2" progressive="True" type="video">, <Stream: itag="18" mime_type="video/mp4" res="360p" fps="30fps" vcodec="avc1.42001E" acodec="mp4a.40.2" progressive="True" type="video">, <Stream: itag="22" mime_type="video/mp4" res="720p" fps="30fps" vcodec="avc1.64001F" acodec="mp4a.40.2" progressive="True" type="video">') == ['17', '18', '22']

def main():
    test_valid()
    test_function_2()
    test_available_reso()

if __name__ == "__main__":
    main()